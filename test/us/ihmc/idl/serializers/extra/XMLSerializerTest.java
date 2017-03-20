package us.ihmc.idl.serializers.extra;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import us.ihmc.idl.generated.Chat.ChatMessage;
import us.ihmc.idl.generated.Chat.ChatMessagePubSubType;
import us.ihmc.idl.generated.IDLElement.IDLElementTest;
import us.ihmc.idl.generated.IDLElement.IDLElementTestPubSubType;

public class XMLSerializerTest
{
   @Test(expected=IOException.class)
   public void testException() throws IOException
   {
      IDLElementTestPubSubType dataType = new IDLElementTestPubSubType();
      XMLSerializer<IDLElementTest> serializer = new XMLSerializer<>(dataType);
      
      IDLElementTest testElement = JSONSerializerTest.createPopulatedIDLElementTest();
      
      serializer.serializeToString(testElement);
      
      
   }
   @Test
   public void test() throws IOException
   {
      ChatMessagePubSubType dataType = new ChatMessagePubSubType();
      XMLSerializer<ChatMessage> serializer = new XMLSerializer<>(dataType);
      

      ChatMessage msg = new ChatMessage();
      msg.getSender().append("Java");
      msg.getMsg().append("Hello World");
      
      String xml = serializer.serializeToString(msg);
      
      ChatMessage res = serializer.deserialize(xml);
      
      assertEquals(msg, res);
      
   }

}
