package com.mas.quotation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.mas.quotation.util.Constant;

@Configuration
public class AmazonSesClient {

  @Bean
  AmazonSimpleEmailService getAmazonSimpleEmailService() {
    return AmazonSimpleEmailServiceClientBuilder.standard()
        .withCredentials(getAwsCredentialProvider())
        .withRegion(Constant.AWS_REGION)
        .build();
  }

  private AWSCredentialsProvider getAwsCredentialProvider() {
    AWSCredentials awsCredentials =
        new BasicAWSCredentials(Constant.AWS_ACCESS_KEY, Constant.AWS_SECRET_KEY);
    return new AWSStaticCredentialsProvider(awsCredentials);
  }
}
