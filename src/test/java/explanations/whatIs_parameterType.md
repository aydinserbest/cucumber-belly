Temel Olarak @ParameterType Nedir?
@ParameterType, Cucumber’da adımlarımızda (steps) geçen bazı kelimeleri veya cümleleri, 
kod içinde anlamlı bir nesneye çevirmemize yarayan bir özellik.
Bu, adımda geçen bir ifadeyi belirli bir nesneye dönüştürmemizi sağlar.
Örneğin, bir adımda geçen "Berlin" kelimesini bir Destination nesnesine dönüştürebiliriz.

"Özel bir nesneye dönüştürmek" ile kastettiğim, 
senaryoda geçen bir metin parçasını Java'daki özel bir sınıfa ait nesneye çevirmek. 
Yani, basit bir String veya int değeri yerine, 
senaryoda yer alan bir bilgiyi daha anlamlı ve doğrudan kullanabileceğin bir nesneye çevirmek.

Bir Örnek Üzerinden Açıklayalım
Diyelim ki bir uçuş sadakat programımız var ve "Frequent Flyer Member" adında özel bir sınıf tanımladık. 
Bu sınıf, üyelerin seviyelerini (örneğin, Standart, Altın, Gümüş) tutuyor. 
Senaryolarımızda üyelerin seviyelerini "Altın Üye" veya "Gümüş Üye" olarak belirttiğimizi düşünelim. 
Şimdi, her senaryoda bu üyelik seviyesini FrequentFlyerMember nesnesi olarak almak işimizi kolaylaştırır.

FrequentFlyerMember örneğini somutlaştırarak Gold, Silver ve Bronze üyelerin nasıl farklı özelliklere sahip olabileceğini gösterelim. 
Bu örnek, üyelik seviyesine göre ayrıcalıkların nasıl değişebileceğini gösterecek.

Senaryo: Üyelik Seviyelerine Göre Puan Kazanma
Diyelim ki uçuş puanları kazanılan bir sistemimiz var ve üyelik seviyesi puan miktarını etkiliyor:

Gold Üye: Her uçuşta %50 daha fazla puan kazanır.
Silver Üye: Her uçuşta %20 daha fazla puan kazanır.
Bronze Üye: Normal puan kazanır, ekstra puan yoktur.
Bu durumu FrequentFlyerMember sınıfında nasıl kodlayabileceğimizi görelim.

@ParameterType Kullanımı ile Örnek
Feature dosyamızda şu adım olsun:

Given Cathy is a Gold Frequent Flyer member

Eğer Gold Frequent Flyer member ifadesini sadece String olarak alırsak, 
adım tanımlamasında manuel olarak bu metni yorumlamak zorunda kalırız. 
Fakat @ParameterType ile doğrudan bir FrequentFlyerMember nesnesi olarak alabiliriz:

1. FrequentFlyerMember Sınıfını Tanımlayalım

   public class FrequentFlyerMember {
   private String name;
   private String level; // Gold, Silver, Bronze
   private int points;

   public FrequentFlyerMember(String name, String level) {
   this.name = name;
   this.level = level;
   this.points = 0; // Başlangıç puanı
   }

   // withLevel metodu, belirli bir üyelik seviyesinde nesne oluşturan statik bir metot
   public static FrequentFlyerMember withLevel(String level) {
   return new FrequentFlyerMember(null, level); // İsmi boş bırakıyoruz, sonra adımda set edebiliriz
   }

   public void earnPoints(int basePoints) {
   switch (this.level) {
   case "Gold":
   this.points += basePoints * 1.5;
   break;
   case "Silver":
   this.points += basePoints * 1.2;
   break;
   case "Bronze":
   this.points += basePoints;
   break;
   default:
   throw new IllegalArgumentException("Geçersiz üyelik seviyesi: " + this.level);
   }
   }

   // Getter ve Setter metodları
   public int getPoints() {
   return points;
   }

   public String getLevel() {
   return level;
   }

   public void setName(String name) {
   this.name = name;
   }
   }

   Bu sınıf:

level değişkenine göre üyelik seviyesini belirler.
earnPoints metodu ile üyelik seviyesine göre puan ekler.
getPoints ve getLevel metotları ile puan ve seviye bilgilerini döndürür.
withLevel Metodunun İşlevi
withLevel metodu, FrequentFlyerMember sınıfında statik bir metot olarak tanımlandı.
new FrequentFlyerMember(null, level) ifadesiyle, FrequentFlyerMember sınıfından bir nesne oluşturuluyor ve ismi null olarak bırakılıyor (ismi daha sonra setName ile adım tanımında belirteceğiz).
Neden withLevel Kullandık?
Bu tür bir statik yardımcı metot, @ParameterType içinde belirli bir seviyede (örneğin, Gold, Silver, Bronze) nesne oluşturmamıza olanak tanır ve bu işlemi kısa ve düzenli hale getirir.

Artık withLevel metodu, @ParameterType'ın içinden çağrılabilir ve FrequentFlyerMember nesnesi oluşturabilir.

   2. @ParameterType Tanımı Yapma
      Şimdi, @ParameterType kullanarak 
   "Gold Frequent Flyer member" 
   gibi bir ifadeyi FrequentFlyerMember nesnesine çevirelim:


@ParameterType("(Gold|Silver|Bronze) Frequent Flyer member")
public FrequentFlyerMember frequentFlyer(String level) {
return FrequentFlyerMember.withLevel(level);
}
Bu @ParameterType, "Gold Frequent Flyer member" gibi ifadeleri FrequentFlyerMember nesnesine çevirir.

3. Step Definition Tanımlama
   Cucumber adım tanımını yapalım. 
Senaryomuzda puan kazanmaları gerekiyor, yani Gold üyeler %50, Silver üyeler %20 ekstra puan alacak.


@Given("{string} is a {frequentFlyer}")
public void defineFrequentFlyerMember(String name, FrequentFlyerMember member) {
member.setName(name);
member.earnPoints(100); // 100 puan kazanımı simgeledik
System.out.println(name + " kazandığı puan: " + member.getPoints());
}
4. Nasıl Çalışır?
   Şimdi, feature dosyamızda şöyle bir senaryo olduğunu düşünelim:

gherkin
Copy code
Scenario: Gold üye olarak daha fazla puan kazanma
Given Cathy is a Gold Frequent Flyer member
Then she should have 150 points
Burada:

Gold Üye: 100 puan üzerinden %50 daha fazla puan kazanarak 150 puan alır.
Silver Üye: 100 puan üzerinden %20 daha fazla puan kazanarak 120 puan alır.
Bronze Üye: Normal 100 puan alır.
Özetle:
Bu örnekle:

FrequentFlyerMember sınıfı üyelik seviyesine göre ekstra puan kazanmayı sağlıyor.
@ParameterType ile Cucumber, Gold, Silver veya Bronze seviyesini otomatik olarak 
FrequentFlyerMember nesnesine çeviriyor.
Bu şekilde üyelik seviyeleriyle ilgili farklı işlemleri kolayca yapabiliyoruz.
Ne Sağladı?
Bu sayede:

Nesneye Dönüştürme:
"Gold Frequent Flyer member" gibi metinleri doğrudan FrequentFlyerMember nesnesine çevirdik.
Kod Basitliği: 
Adım tanımlamalarında bu metni manuel olarak analiz etmek zorunda kalmadık.
Bu, "özel bir nesneye dönüştürmek" dediğimiz şeyin tam olarak nasıl çalıştığını gösterir.
```

İlk adımda, ismi "John" ve seviyesi "Silver" olan bir FrequentFlyerMember nesnesi oluşturalım.

Bu nesneyi, FrequentFlyerMember sınıfının yapıcı (constructor) metodunu doğrudan kullanarak basitçe oluşturabiliriz. Şöyle yapalım:

1. FrequentFlyerMember Nesnesini Oluşturalım
java
Copy code
FrequentFlyerMember john = new FrequentFlyerMember("John", "Silver");
Bu satır, "John" isminde ve "Silver" seviyesinde bir FrequentFlyerMember nesnesi oluşturur. Şimdi john adında bir nesnemiz var ve seviyesi Silver olarak ayarlandı.


withLevel metodunu Cucumber step definition'dan bağımsız olarak da kullanabiliriz. Bu metot, FrequentFlyerMember nesnesini yalnızca üyelik seviyesini belirterek oluşturmak için tasarlandı. Ancak withLevel metodu sadece seviyesi olan bir nesne oluşturduğu için ismi daha sonra ayrı bir şekilde set etmemiz gerekiyor.

withLevel ile Nesne Oluşturma
Eğer withLevel metodunu kullanarak bir nesne oluşturmak istersek, şu şekilde yapabiliriz:

java
Copy code
FrequentFlyerMember john = FrequentFlyerMember.withLevel("Silver");
john.setName("John"); // İsmi sonradan ayarlıyoruz
Ne Yaptık?
İlk satırda withLevel metodu aracılığıyla seviyeyi "Silver" olarak belirledik.
İkinci satırda ise setName metodunu kullanarak ismi "John" olarak ayarladık.
Bu yöntem, withLevel kullanarak sadece seviyeyi belirleyen bir nesne oluşturdu ve sonrasında ismi manuel olarak ekledik.

İşte bu adımlarda olanlar:

Feature dosyasında örneğin "John is a Silver Frequent Flyer member" adımını yazıyorsun.

@ParameterType, "Silver" seviyesini FrequentFlyerMember sınıfına bağlı frequentFlyer metoduna geçiriyor:

java
Copy code
@ParameterType("(Gold|Silver|Bronze) Frequent Flyer member")
public FrequentFlyerMember frequentFlyer(String level) {
    return FrequentFlyerMember.withLevel(level); // Sadece seviyeyi ayarlıyor, ismi değil
}
Step Definition (adım tanımı) metodunda ise, name (John) parametresi String name olarak ve FrequentFlyerMember nesnesi de member parametresi olarak geliyor:

java
Copy code
@Given("{string} is a {frequentFlyer}")
public void defineFrequentFlyerMember(String name, FrequentFlyerMember member) {
    member.setName(name); // İsmi burada ayarlıyoruz
    System.out.println(name + " is a " + member.getLevel() + " Frequent Flyer member.");
}
Sonuç: Böylece, member nesnesi Silver seviyesinde ama ismi henüz ayarlanmamış olarak geliyor. Adım tanımı içinde member.setName(name); diyerek ismi ekliyoruz.

Yani, @ParameterType sayesinde FrequentFlyerMember nesnesi sadece seviye ile oluşturulmuş oluyor, ismini adım tanımında ekliyoruz

@ParameterType("(Gold|Silver|Bronze) Frequent Flyer member") ifadesindeki "Frequent Flyer member" kısmı, senaryoda kullanılan metinle eşleşmesini sağlayan bir kalıptır. Bu kalıp, feature dosyasındaki adımların FrequentFlyerMember nesnesine dönüştürülmesini sağlar.

Örneğin, feature dosyasında şu adım yazılı olsun:

gherkin
Copy code
Given John is a Silver Frequent Flyer member
Buradaki "Silver Frequent Flyer member" ifadesi, @ParameterType'da tanımlanan (Gold|Silver|Bronze) Frequent Flyer member kalıbına uyuyor. Boşluklu yazılması, feature dosyasında bu ifadenin nasıl geçtiğini tanımlamak içindir; yani Gold, Silver veya Bronze seviyesinin ardından Frequent Flyer member yazılacağını belirtir.

Detaylı Açıklama
(Gold|Silver|Bronze) kısmı, bu @ParameterType'ın sadece "Gold", "Silver" veya "Bronze" kelimeleriyle eşleşeceğini belirtir.
"Frequent Flyer member" ifadesi, bu kelimelerin ardından geleceğini belirtir. Bu ifade, boşluklu ve aynen bu şekilde kullanılmalıdır.
Özetle
Frequent Flyer member ifadesi, boşluklu yazılması sayesinde feature dosyasında Gold Frequent Flyer member, Silver Frequent Flyer member gibi ifadelerle eşleşir. @ParameterType bu tür ifadeleri yakalayarak, belirttiğin seviyeye sahip bir FrequentFlyerMember nesnesi oluşturur.