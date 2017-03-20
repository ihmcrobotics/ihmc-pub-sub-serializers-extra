package us.ihmc.idl.generated.IDLNestedElement;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.CDR;
import us.ihmc.idl.InterchangeSerializer;
import us.ihmc.idl.IDLStruct;
import java.util.Arrays;

/**
* 
* Definition of the class "NestedElement" defined in NestedElement.idl. 
*
* This file was automatically generated from NestedElement.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit NestedElement.idl instead.
*
*/
public class NestedElement implements IDLStruct<NestedElement>
{
    public NestedElement()
    {
        	stringTest_ = new StringBuilder(255); 
        
        
    }
    @Override
    public void set(NestedElement other)
    {
        	stringTest_.setLength(0);
        	stringTest_.append(other.stringTest_);
        	longTest_ = other.longTest_;

    }

        public void setStringTest(String stringTest)
        {
        	stringTest_.setLength(0);
        	stringTest_.append(stringTest);
        }
        
        public String getStringTestAsString()
        {
        	return getStringTest().toString();
        }

    public StringBuilder getStringTest()
    {
        return stringTest_;
    }

        
    public void setLongTest(int longTest)
    {
        longTest_ = longTest;
    }

    public int getLongTest()
    {
        return longTest_;
    }

        


	public static int getMaxCdrSerializedSize()
	{
		return getMaxCdrSerializedSize(0);
	}

	public static int getMaxCdrSerializedSize(int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	
	    return current_alignment - initial_alignment;
	}


	public final static int getCdrSerializedSize(NestedElement data)
	{
		return getCdrSerializedSize(data, 0);
	}

	public final static int getCdrSerializedSize(NestedElement data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getStringTest().length() + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	
	    return current_alignment - initial_alignment;
	}
	
	@Override
	public final void serialize(CDR cdr)
	{


	    if(stringTest_.length() <= 255)
	    cdr.write_type_d(stringTest_);else
	        throw new RuntimeException("stringTest field exceeds the maximum length");

	    cdr.write_type_2(longTest_);
	}
	
	@Override
	public final void deserialize(CDR cdr)
	{

	    	cdr.read_type_d(stringTest_);	

	    	longTest_ = cdr.read_type_2();	
	}
	
	@Override
	public final void serialize(InterchangeSerializer ser)
	{
			    ser.write_type_d("stringTest", stringTest_);
			    
			    ser.write_type_2("longTest", longTest_);
			    
	}
	
	@Override
	public final void deserialize(InterchangeSerializer ser)
	{
	    			ser.read_type_d("stringTest", stringTest_);	
	    	    
	    			longTest_ = ser.read_type_2("longTest");	
	    	    
	}

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof NestedElement)) return false;
        NestedElement otherMyClass = (NestedElement)other;
        boolean returnedValue = true;

        returnedValue &= us.ihmc.idl.IDLTools.equals(this.stringTest_, otherMyClass.stringTest_);
                
        returnedValue &= this.longTest_ == otherMyClass.longTest_;

                

        return returnedValue;
    }
    
     @Override
    public String toString()
    {
		StringBuilder builder = new StringBuilder();
		
      	builder.append("NestedElement {");
        builder.append("stringTest=");
        builder.append(this.stringTest_);

                builder.append(", ");
        builder.append("longTest=");
        builder.append(this.longTest_);

                
        builder.append("}");
		return builder.toString();
    }

    private StringBuilder stringTest_; 
    private int longTest_; 

}