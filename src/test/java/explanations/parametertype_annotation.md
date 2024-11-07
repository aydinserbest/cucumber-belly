@ParameterType kullanmak için feature dosyasında tablo yerine 
tek bir satırda virgülle ayrılmış bir metin yazmamız gerekiyor.

Neden?
Tablo Kullanımı: 
Eğer feature dosyasında bir tablo varsa (DataTable), 
Cucumber bunu otomatik olarak bir DataTable nesnesine dönüştürür. 
Bu durumda DataTable'ı doğrudan List<Destination> veya List<Map<String, String>> gibi bir türe çevirebiliriz.

@ParameterType Kullanımı: 
@ParameterType ise virgüllerle ayrılmış tek satırlık bir metin için uygundur. 
@ParameterType, bir metni belirttiğimiz kurallara göre özel bir nesneye dönüştürmemize olanak tanır.

Örneklerle Açıklayalım
1. @ParameterType ile Virgülle Ayrılmış Metin
   Feature dosyasında tek satırda virgülle ayrılmış bir liste varsa:

Then the available destinations should be Berlin, Paris, New York

Bu durumda @ParameterType kullanarak "Berlin, Paris, New York" ifadesini 
List<Destination>'a dönüştürebiliriz.

2. DataTable ile Tablo Kullanımı
   Feature dosyasında tablo varsa:

Then the available destinations should be:
| city      |
| Berlin    |
| Paris     |
| New York  |

Bu durumda DataTable özelliğini kullanarak tabloyu List<Destination> türüne çevirmek daha uygundur.

Özetle
Eğer @ParameterType kullanmak istiyorsak, 
feature dosyasında virgüllerle ayrılmış tek bir satır kullanılmalı. 
Eğer tablo kullanıyorsak DataTable ile çalışmak daha uyumlu olur.