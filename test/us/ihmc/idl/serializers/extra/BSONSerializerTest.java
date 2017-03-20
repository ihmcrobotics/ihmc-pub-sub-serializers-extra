package us.ihmc.idl.serializers.extra;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import us.ihmc.idl.generated.IDLElement.IDLElementTest;
import us.ihmc.idl.generated.IDLElement.IDLElementTestPubSubType;

public class BSONSerializerTest
{

   @Test
   public void test() throws IOException
   {
      IDLElementTestPubSubType dataType = new IDLElementTestPubSubType();
      BSONSerializer<IDLElementTest> serializer = new BSONSerializer<>(dataType);
      
      IDLElementTest testElement = JSONSerializerTest.createPopulatedIDLElementTest();
      
      byte[] data = serializer.serializeToBytes(testElement);
      
      
      IDLElementTest result = serializer.deserialize(data);
      
      assertEquals(testElement, result);
      
   }

}
