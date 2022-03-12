/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rc4;
import java.io.*;
/**
 *
 * @author Devrim
 */

class RC4{

    static  void Goruntule(int disp[]){
    char convert[]=new char[disp.length];
    for(int l=0;l<disp.length;l++){
    convert[l]=(char)disp[l];
        System.out.println(convert[l]);
    }
    
    }
    
    
    
    public static void main(String[] args) throws IOException {
      
        int temp=0;
        String ptext; //Bu bizim gireceğimiz bilgidir
        String key;   //Anahtar
        int s[]=new int[256]; //Bilgimiz için 0 255 arası bir dizi tanımladık
        int k[]=new int[256]; // Anahtarımız için 0 255 arası bir dizi tanımladık
        
                      
        DataInputStream in=new DataInputStream(System.in); //Klavyeden girilecek bilgi ve anahtar için tanımladık
        
        System.out.println("\nGirilecek Bilgi");
        ptext=in.readLine();
        System.out.println("\n\nAnahtarı Giriniz.");
        key=in.readLine();
        
        char ptextc[]=ptext.toCharArray(); // Biz burda ptextc içeriğine ptext stringteki harfleri aldık ve atadık.
        char keyc[]=key.toCharArray();    //Burada ise girilen anahtarın karakterlerini alarak keyc içine atadık
        
        int cipher[]=new int[ptext.length()]; // burada ise girilen bilgi kadar uzunlukta şifre dizisini oluşturduk
        int decrypt[]=new int[ptext.length()]; // burası tam tersi aynı boyutta ama çözmek için oluşturuduk.
         
        int ptexti[]=new int[ptext.length()];  // burada ise gene girilen bilgi değerimiz kadar yeni bir bilgi dizisi oluşturduk
        int keyi[]= new int[ptext.length()];// girilen anahtar  için gene yeni bir dizi oluşturduk.
        
        for(int i=0;i<ptext.length();i++){
        
        ptexti[i]=(int)ptextc[i];  // burda girilen bilgi kelimenin harflerinin ascii değerini alıp diziye atıyor
        
        }
        for(int i=0;i<key.length();i++){
        keyi[i]=(int)keyc[i];  // anahtarın ascii değerini alıp atıyor
        }
        
       for(int i=0;i<255;i++){
       s[i]=i;  // 0 dan 255 e kadar tüm değerleri s dizisine atıyor.
       k[i]=keyi[i%key.length()]; // burda ise her i için anahtar uzunluğuna mod alıp k anahtarına atıyor. 255 olduğundan i%255 oluyor.
       }
       int j=0;
       for(int i=0;i<255;i++){
       j=(j+s[i]+k[i])%255; // burda ise s bilgisini karıştırmak için işlem yapıyor 
       // örneğin J=0 ve s[0] artık kaç ise ve de k[i] değerini alıp toplayıp, mod değerini alıp j'ye atıyor. sonra yer değiştirme işlemi.
       temp=s[i];
       s[i]=s[j];
       s[j]=temp;
       }
        
       int i=0;
           j=0;
       int z=0;
       
       for(int l=0;l<ptext.length();l++){
       i=(l+1)%256; // burda ise  l den bir fazlasını alıp mod 255 yapıp i'ye atıyor
       j=(j+s[i])%256; // sonra j ye j+s[i] değerini toplayıp atıyor i=1 den başladı.
       temp=s[i];     // sonra gene yer değiştirme
       s[i]=s[j];
       s[j]=temp;
       z=s[(s[i]+s[j])%256]; // burada ise i ve j indisteki değerleri alıp mod 256 ya göre değerini alıp sonra s dizisinin indisi oluyor
       // sonra bunu z ye atıyor 
       cipher[l]=z^ptexti[l]; // burda şifreli metni elde ediyor
       decrypt[l]=z^cipher[l]; // burada ise çözülmüş halini elde ediyor.
       
       }
       
        System.out.print("\n\nŞifrelenmiş Hali:");
        System.out.println();
        Goruntule(cipher);
        System.out.print("\n\nÇözülmüş Hali");
        System.out.println();
        Goruntule(decrypt);
        
      
        
        
        
        
        
    }

}