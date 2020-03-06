package com.mostafa.projects.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Value("${mongo.db}")
	private String dbName;
	@Value("${mongo.url}")
	private String mongoUrl;

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@Override
	public MongoClient mongoClient() {
		MongoClientURI mongoClientURI = new MongoClientURI(mongoUrl);
		return new MongoClient(mongoClientURI);
	}
}