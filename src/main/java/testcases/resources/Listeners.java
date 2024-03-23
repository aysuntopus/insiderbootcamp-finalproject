package testcases.resources;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.bson.Document;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testcases.components.AbstractComponent;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Listeners extends AbstractComponent implements ITestListener {
	private MongoCollection<Document> _webCollection;
	private MongoClient _mongoClient;

	public Listeners() throws Exception {
		super();
	}

	@Override
	public void onStart(ITestContext context) {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		_mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = _mongoClient.getDatabase("customdb");
		// creates collection
		_webCollection = database.getCollection("live");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String className = result.getMethod().getRealClass().getName();
		Long executionTime = result.getEndMillis() - result.getStartMillis();

		Document d1 = new Document();
		d1.append("methodName", methodName);
		d1.append("className", className);
		d1.append("status", "PASS");
		d1.append("executionTime", executionTime);

		_webCollection.insertOne(d1);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String className = result.getMethod().getRealClass().getName();
		Long executionTime = result.getEndMillis() - result.getStartMillis();

		Document d1 = new Document();
		d1.append("methodName", methodName);
		d1.append("className", className);
		d1.append("status", "FAIL");
		d1.append("executionTime", executionTime);

		String filePath = null;
		try {
			filePath = takeScreenShot(result.getMethod().getMethodName());
			File file = new File(filePath);
			byte[] bytes = FileUtils.readFileToByteArray(file);
			d1.append("errorImage", bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		_webCollection.insertOne(d1);
	}

	@Override
	public void onFinish(ITestContext context) {
		_mongoClient.close();
	}
}
