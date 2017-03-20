package us.ihmc.idl.serializers.extra;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import us.ihmc.idl.generated.IDLElement.IDLElementTest;
import us.ihmc.idl.generated.IDLElement.IDLElementTestPubSubType;

public class YAMLSerializerTest
{

   @Test
   public void test() throws IOException
   {
      IDLElementTestPubSubType dataType = new IDLElementTestPubSubType();
      YAMLSerializer<IDLElementTest> serializer = new YAMLSerializer<>(dataType);
      
      IDLElementTest testElement = JSONSerializerTest.createPopulatedIDLElementTest();
      
      String data = serializer.serializeToString(testElement);
    
      IDLElementTest result = serializer.deserialize(data);
      
      assertEquals(testElement, result);
      
   }

}
