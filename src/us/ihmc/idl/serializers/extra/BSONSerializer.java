package us.ihmc.idl.serializers.extra;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.undercouch.bson4jackson.BsonFactory;
import us.ihmc.idl.IDLStruct;
import us.ihmc.pubsub.TopicDataType;

/**
 * JSON Serializer. Serializes IDL files to BSON (MongoDB Binary JSON) representation using Jackson and bson4jackson
 *  
 * @author Jesper Smith
 *
 * @param <T> IDL element type
 */
public class BSONSerializer<T extends IDLStruct<?>> extends AbstractSerializer<T>
{
   public BSONSerializer(TopicDataType<T> topicDataType)
   {
      super(topicDataType, new ObjectMapper(new BsonFactory()));
   }

   @Override
   @Deprecated
   public String serializeToString(T data)
   {
      throw new RuntimeException("BSON is a binary based format. Serialization to string is not supported");
   }
}
