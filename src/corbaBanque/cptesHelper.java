package corbaBanque;


/**
* corbaBanque/cptesHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Banque.idl
* mercredi 1 d�cembre 2021 09 h 11 WAT
*/

abstract public class cptesHelper
{
  private static String  _id = "IDL:corbaBanque/cptes:1.0";

  public static void insert (org.omg.CORBA.Any a, corbaBanque.Compte[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static corbaBanque.Compte[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = corbaBanque.CompteHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (corbaBanque.cptesHelper.id (), "cptes", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static corbaBanque.Compte[] read (org.omg.CORBA.portable.InputStream istream)
  {
    corbaBanque.Compte value[] = null;
    int _len0 = istream.read_long ();
    value = new corbaBanque.Compte[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = corbaBanque.CompteHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, corbaBanque.Compte[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      corbaBanque.CompteHelper.write (ostream, value[_i0]);
  }

}
