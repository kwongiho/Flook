package Calculate;

public class CalculateCode {
	public static String makeCode(String codeType,int codeNum)
	{
		if      ( codeNum > 999999999) return codeType+codeNum;
        else if ( codeNum > 99999999) return codeType+"0"+codeNum;
        else if ( codeNum > 9999999) return codeType+"00"+codeNum;
        else if ( codeNum > 999999) return codeType+"000"+codeNum;
        else if ( codeNum > 99999) return codeType+"0000"+codeNum;
        else if ( codeNum > 9999) return codeType+"00000"+codeNum;
        else if ( codeNum > 999) return codeType+"000000"+codeNum;
        else if ( codeNum > 99) return codeType+"0000000"+codeNum;
        else if ( codeNum > 9) return codeType+"00000000"+codeNum;
        else return codeType+"000000000"+codeNum;
	}

}
