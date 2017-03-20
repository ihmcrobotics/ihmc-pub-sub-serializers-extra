package us.ihmc.idl.serializers.extra;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import us.ihmc.idl.IDLStruct;
import us.ihmc.pubsub.TopicDataType;

/**
 * Abstract entry point to serialize/deserialize using Jackson modules. 
 * 
 * Use [format]Serializer for concrete implementations.
 * 
 * To create custom serializers, extend thiss class and pass in the correct ObjectMapper class.
 * 
 * @author Jesper Smith
 *
 * @param <T>
 */
public abstract class AbstractSerializer<T extends IDLStruct<?>>
{
   protected final ObjectMapper mapper;
   protected final TopicDataType<T> topicDataType;

   protected AbstractSerializer(TopicDataType<T> topicDataType, ObjectMapper mapper)
   {
      this.topicDataType = topicDataType;
      this.mapper = mapper;
   }

   /**
    * Serialize data from IDL representation using Jackson.
    * 
    * Data will be serialized with the topic data type type as the first node.
    * 
    * @param data data structure generated using IHMC Pub Sub Generator
    * @return String serialized representation of the data.
    * @throws IOException 
    */
   public String serializeToString(T data) throws IOException
   {
      try
      {
         return mapper.writeValueAsString(serializeAndCatch(data));
      }
      catch (JsonProcessingException e)
      {
         throw new IOException("Invalid call to Jackson made internally in the serializer. Please file a bug report", e);
      }
   }

   /**
    * Serialize data from IDL representation using Jackson.
    * 
    * Data will be serialized with the topic data type type as the first node.
    * 
    * @param data data structure generated using IHMC Pub Sub Generator
    * @return String serialized representation of the data.
    * @throws IOException 
    */
   public byte[] serializeToBytes(T data) throws IOException
   {
      try
      {
         return mapper.writeValueAsBytes(serializeAndCatch(data));
      }
      catch (JsonProcessingException e)
      {
         throw new IOException("Invalid call to Jackson made internally in the serializer. Please file a bug report", e);
      }
   }

   /**
    * Serialize data from IDL representation using Jackson.
    * 
    * Data will be serialized with the topic data type type as the first node.
    * 
    * @param data data structure generated using IHMC Pub Sub Generator
    * @return String serialized representation of the data.
    */
   public void serialize(File target, T data) throws IOException
   {
      mapper.writeValue(target, serializeAndCatch(data));
   }

   /**
    * Serialize data from IDL representation using Jackson.
    * 
    * Data will be serialized with the topic data type type as the first node.
    * 
    * @param data data structure generated using IHMC Pub Sub Generator
    * @return String serialized representation of the data.
    */
   public void serialize(OutputStream target, T data) throws IOException
   {
      mapper.writeValue(target, serializeAndCatch(data));
   }

   /**
    * Serialize data from IDL representation using Jackson.
    * 
    * Data will be serialized with the topic data type type as the first node.
    * 
    * @param data data structure generated using IHMC Pub Sub Generator
    * @return String serialized representation of the data.
    */
   public void serialize(Writer target, T data) throws IOException
   {
      mapper.writeValue(target, serializeAndCatch(data));
   }

   protected Object serialize(T data) throws IOException
   {
      ObjectNode root = mapper.createObjectNode();
      ObjectNode node = root.putObject(topicDataType.getName());
      data.serialize(new JacksonInterchangeSerializer(node, true));
      return root;
   }

   private Object serializeAndCatch(T data) throws IOException
   {
      try
      {
         return serialize(data);
      }
      catch (UnsupportedFeatureException e)
      {
         throw new IOException(e);
      }
   }

   /**
    * Deserialize to IDL representation.
    * 
    * The first node is expected to contain the topic data type. If no data is present or if the first node does not
    * contain the topic data type null is returned.
    * 
    * @param source data stream to deserialize
    * @return Data type or null if the input is empty or does not contain the topic data type.
    * 
    * @throws IOException if the input is malformed.
    */
   public T deserialize(Reader source) throws IOException
   {
      return deserializeAndCatch(mapper.readTree(source));
   }

   /**
    * Deserialize to IDL representation.
    * 
    * The first node is expected to contain the topic data type. If no data is present or if the first node does not
    * contain the topic data type null is returned.
    * 
    * @param source data stream to deserialize
    * @return Data type or null if the input is empty or does not contain the topic data type.
    * 
    * @throws IOException if the input is malformed.
    */
   public T deserialize(InputStream source) throws IOException
   {
      return deserializeAndCatch(mapper.readTree(source));
   }

   /**
    * Deserialize to IDL representation.
    * 
    * The first node is expected to contain the topic data type. If no data is present or if the first node does not
    * contain the topic data type null is returned.
    * 
    * @param source data stream to deserialize
    * @return Data type or null if the input is empty or does not contain the topic data type.
    * 
    * @throws IOException if the input is malformed.
    */
   public T deserialize(byte[] source) throws IOException
   {
      return deserializeAndCatch(mapper.readTree(source));
   }

   /**
    * Deserialize to IDL representation.
    * 
    * The first node is expected to contain the topic data type. If no data is present or if the first node does not
    * contain the topic data type null is returned.
    * 
    * @param source data stream to deserialize
    * @return Data type or null if the input is empty or does not contain the topic data type.
    * 
    * @throws IOException if the input is malformed.
    */
   public T deserialize(String source) throws IOException
   {
      return deserializeAndCatch(mapper.readTree(source));
   }

   /**
    * Deserialize to IDL representation.
    * 
    * The first node is expected to contain the topic data type. If no data is present or if the first node does not
    * contain the topic data type null is returned.
    * 
    * @param source data stream to deserialize
    * @return Data type or null if the input is empty or does not contain the topic data type.
    * 
    * @throws IOException if the input is malformed.
    */
   public T deserialize(File source) throws IOException
   {
      return deserializeAndCatch(mapper.readTree(source));
   }

   /**
    * Deserialize to IDL representation.
    * 
    * The first node is expected to contain the topic data type. If no data is present or if the first node does not
    * contain the topic data type null is returned.
    * 
    * @param source data stream to deserialize
    * @return Data type or null if the input is empty or does not contain the topic data type.
    * 
    * @throws IOException if the input is malformed.
    */
   public T deserialize(URL source) throws IOException
   {
      return deserializeAndCatch(mapper.readTree(source));
   }

   protected T deserialize(JsonNode root) throws IOException
   {

      JsonNode node = root.get(topicDataType.getName());

      if (node != null && node.isObject())
      {
         JacksonInterchangeSerializer serializer = new JacksonInterchangeSerializer((ObjectNode) node, true);
         T data = topicDataType.createData();
         data.deserialize(serializer);
         return data;
      }
      else
      {
         return null;
      }

   }

   private T deserializeAndCatch(JsonNode root) throws IOException
   {
      if (root != null)
      {
         try
         {
            return deserialize(root);
         }
         catch (UnsupportedFeatureException e)
         {
            throw new IOException(e);
         }
      }
      else
      {
         return null;
      }
   }

}