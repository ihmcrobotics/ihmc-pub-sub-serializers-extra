package us.ihmc.idl.serializers.extra;

public class UnsupportedFeatureException extends RuntimeException
{

   /**
    * 
    */
   private static final long serialVersionUID = -7167341851948288426L;
   
   public UnsupportedFeatureException(String msg)
   {
      super(msg);
   }

}
