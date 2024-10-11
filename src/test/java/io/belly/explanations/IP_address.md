Scenario: Server is active
Given the server with IP 192.168.0.1 is active


1-yol:
@Given("^the server with IP (\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}) is active$")
public void theServerWithIPIsActive(String ipAddress) {
System.out.println("The server with IP " + ipAddress + " is active");
}
IP adreslerinde her segmentin 0 ile 255 arasında olması gerekliliği, 
IPv4 protokolünün teknik yapısıyla ilgilidir. IPv4 adresi, 32-bitlik bir adresleme sistemidir 
ve bu 32 bit, dört ayrı 8-bitlik bölüme (segment) ayrılır. 
Her 8-bit bölüm, 0 ile 255 arasında bir sayı ile temsil edilir.

Teknik Açıklama:
Bir IP adresi, dört segmentten oluşur ve her segment 8 bit'lik bir değeri temsil eder. 
Bu nedenle, her segment şu şekilde hesaplanır:

8-bit ile ifade edilen en küçük değer 0, en büyük değer ise 255'tir.
Yani, her segmentin değeri 0 ile 255 arasında olmalıdır.
Neden 0-255?
8 bit'lik bir bölümde, ikilik sayı sisteminde 00000000 (decimalde 0) ile 
11111111 (decimalde 255) arasında bir aralık mümkündür.
Bu yüzden, her segmentin değeri 0 ile 255 arasında olmak zorundadır.
Örnek olarak:

192.168.0.1 bir geçerli IP adresidir çünkü her segment 0-255 aralığındadır.
999.999.999.999 geçersiz bir IP adresidir, çünkü segmentlerdeki sayılar 255'ten büyüktür.
Regex'in Bu Durumu Kontrol Etmemesi:
Basit bir \\d{1,3} regex'i, segmentin kaç rakamdan oluştuğunu kontrol eder (1 ila 3 rakam), 
ancak bu segmentin geçerli bir IP segmenti olup olmadığını kontrol etmez. 
Örneğin, 999 gibi geçersiz bir IP segmentini de yakalayabilir. 
O yüzden, IP adreslerinin geçerliliğini kontrol etmek istiyorsan 
daha karmaşık bir regex'e ihtiyaç duyarsın:alttaki gibi.
2-yol:
@Given("^the server with IP (25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?) is active$")
public void theServerWithIPIsActive(String ipAddress) {
System.out.println("Server IP: " + ipAddress);
}
Bu regex, her IP segmentinin 0-255 arasında olmasını sağlar ve kısa, okunabilir bir yapıya sahiptir. 
Her segment 0-255 arasında olacak şekilde doğrulanır
Açıklama:
25[0-5]: 250-255 arasındaki değerleri yakalar.
2[0-4][0-9]: 200-249 arasındaki değerleri yakalar.
[01]?[0-9][0-9]?: 0-199 arasındaki değerleri yakalar, bu segmentler tek basamaklı 
veya iki basamaklı olabilir.
Bu yapı her segmenti 0-255 arasında kısıtlar ve geçerli bir IPv4 adresi olmasını sağlar. 
Bu regex, 192.168.0.1, 10.0.0.1, ve 255.255.255.255 gibi geçerli IP adreslerini yakalayacaktır, 
ancak 999.999.999.999 gibi geçersiz IP adreslerini yakalamayacaktır.


3-
\\d/{1,3} te rakam sayısı 1-3 arasında olmalıdır.

@Given("^the server with IP (\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}) is active$") Regex'ine Bakarsak Ne Görürüz?
Bu regex yapısına baktığında, IP adresinin her segmenti için 1 ila 3 rakam yakalandığını görürsün:

\\d{1,3}: Her segment 1 ile 3 arasında rakam olabilir. 
Bu, 1 rakamlı veya 2-3 rakamlı segmentlerin hepsini kapsar.
Yani, IP adresindeki bir segment 1, 12, 192 gibi olabilir.
\\.: Her segmentin arasında nokta (.) karakteri bulunur.
Regex'in Genişletilmiş İncelemesi:
\\d{1,3}: IP adresi segmentlerinin her biri 1 ila 3 rakamdan oluşabilir. 
Bu, 1, 192, 255 gibi değerleri kapsar. Yani segmentlerin sadece 3 rakamlı olması gerekmez, 
1 rakamlı bir segment de kabul edilebilir.
Soruya Yanıt:
Bu regex, IP adresindeki 1 ila 3 rakamlı segmentleri doğru şekilde yakalayabilir. 
Dolayısıyla, 192.168.0.1 gibi bir adres için:

192: 3 rakam
168: 3 rakam
0: 1 rakam
1: 1 rakam
Bu regex doğru şekilde bu IP'yi yakalayacaktır. Yani 1 rakamlı segmentler için de çalışır.

Özetle, regex'in içinde \\d{1,3} kısmı, her segmentte 1, 2 veya 3 rakam olmasına izin verir. 
Bu nedenle IP adresindeki 1 rakamlı segmentler de düzgün bir şekilde yakalanır.
