package us.ihmc.idl.serializers.extra;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import us.ihmc.idl.IDLStruct;
import us.ihmc.pubsub.TopicDataType;

/**
 * JSON Serializer. Serializes IDL files to JSON representation using Jackson
 * 
 * @author Jesper Smith
 *
 * @param <T> IDL element type
 */
public class JSONSerializer<T extends IDLStruct<?>> extends AbstractSerializer<T>
{
   public JSONSerializer(TopicDataType<T> topicDataType)
   {
      super(topicDataType, new ObjectMapper(new JsonFactory()));
   }
}
