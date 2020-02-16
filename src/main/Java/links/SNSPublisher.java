package links;

/**
 * @author Yilinlou
 * @date 2/16/20 3:21 下午
 * @Email:ylou7@stevens.edu
 */
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

public class SNSPublisher {
    private static final String TOPIC_ARN_EMAIL="arn:aws:sns:us-east-2:858789323577:MyTopic";
    private static final String EMAIL_SUBJECT="this is a test sns";
    private static final String EMAIL_MESSAGE ="hello world from SNS";
    private static final String EMAIL_SUBJECT_JAVA = "Test SNS Notification Mail From Java";
    private static final String EMAIL_MESSAGE_JAVA = "We are able to create topic, subscribe to that topic and publish to that topic from java";
    private static AmazonSNSClient snsClient=null;

    public void SendMessage(String SMSMessage,String mobile ){
        //Used for authenticating to AWS
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIA4P46VEM4SQBFR63G", "WPMQCnTlibxtoiBWkpNMhBT/yIgE/zPfxCdbTu2f");

        //Create SNS Client
        AmazonSNS snsClient = AmazonSNSClient
                .builder()
                .withRegion(Regions.AP_SOUTHEAST_2)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();


        snsClient.publish(new PublishRequest().withMessage(SMSMessage).withPhoneNumber(mobile));

    }



//    public static void main(String[] args) {
//        SNSPublisher snsPublisher=new SNSPublisher();
//        String s="testttttttt";
//        String mobile="+12018858017";
//        snsPublisher.SendMessage(s,mobile);
//
//
//}




}
