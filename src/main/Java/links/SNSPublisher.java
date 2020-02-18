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


    public void SendMessage(String SMSMessage,String mobile ){
        //Used for authenticating to AWS
        String accesskey="";



        String secrekey="";




        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accesskey,secrekey);

        //Create SNS Client
        AmazonSNS snsClient = AmazonSNSClient
                .builder()
                .withRegion(Regions.AP_SOUTHEAST_2)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();



        snsClient.publish(new PublishRequest().withMessage(SMSMessage).withPhoneNumber(mobile));

    }



    public static void main(String[] args) {
        SNSPublisher snsPublisher=new SNSPublisher();
        String s="ppppppppppp";
        String mobile="+12018858017";
//        String mobile="+12014232678";
        snsPublisher.SendMessage(s,mobile);


}




}
