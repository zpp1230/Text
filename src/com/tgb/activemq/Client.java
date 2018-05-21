package com.tgb.activemq;


import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;  
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;  
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
  
public class Client {  
  
    public static final String HOST = "tcp://wechat.hontech-rdcenter.com:1883";  
    public static final String TOPIC = "11:22:33:44:55:66";  
    private static final String clientid = "client";
    private static MqttTopic topic;
    
      
    
  
    public static void main(String[] args) throws MqttException {     
        
    	MqttClient client=new MqttClient(HOST, clientid,null);
    	
    	MqttConnectOptions options=new MqttConnectOptions();
    	
    	MqttMessage message=new MqttMessage();
    	message.setPayload("hello".getBytes());
    	
    	options.setUserName("admin");
    	options.setPassword("admin".toCharArray());
    	options.setConnectionTimeout(10);
    	options.setKeepAliveInterval(20);
    	options.setCleanSession(true);
    	
    	client.setCallback(new MqttCallback() {
			
			@Override
			public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
				
				System.err.println("arg0 :" + arg0);
				System.err.println("arg1 :" + new String(arg1.getPayload()));
			}
			
			@Override
			public void deliveryComplete(IMqttDeliveryToken arg0) {
				
				System.err.println("deliveryComplete");
			}
			
			@Override
			public void connectionLost(Throwable arg0) {
				
				System.err.println("connectionLost");
			}
		});
    	
    	client.connect(options);
    	topic = client.getTopic(TOPIC);
    	client.publish(topic.toString(),message);
    	client.subscribe(topic.toString());
    	System.err.println(topic);
    }  
  
}  
