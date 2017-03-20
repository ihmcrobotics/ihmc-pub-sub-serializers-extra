package us.ihmc.idl.serializers.extra;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import us.ihmc.idl.IDLStruct;
import us.ihmc.pubsub.TopicDataType;

/**
 * JSON Serializer. Serializes IDL files to YAML representation using Jackson
 * 
 * @author Jesper Smith
 *
 * @param <T> IDL element type
 */
public class YAMLSerializer<T extends IDLStruct<?>> extends AbstractSerializer<T>
{
   public YAMLSerializer(TopicDataType<T> topicDataType)
   {
      super(topicDataType, new ObjectMapper(new YAMLFactory()));
   }
}
