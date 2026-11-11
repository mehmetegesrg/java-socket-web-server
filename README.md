# Java Socket ile Basit Web Sunucusu

Bu proje, herhangi bir 3. parti kütüphane veya framework kullanılmadan, yalnızca Java standart kütüphanesi ve socket programlama ile yazılmış basit bir HTTP web sunucusudur. Sunucu **1989. porttan** hizmet verir ve tarayıcıdan bağlanan her istemciye öğrenci bilgilerini içeren biçimlendirilmiş bir HTML sayfası gönderir.

## Proje Bilgileri

| | |
|---|---|
| **Ad Soyad** | Mehmet Ege Sarıgöl |
| **Öğrenci No** | 1250505035 |
| **Ders** | Nesne Yönelik Programlama |
| **Dil** | Java (JDK 17+) |

## Amaç

- Socket programlama ile temel bir web sunucusunun nasıl çalıştığını göstermek
- HTTP istek/yanıt döngüsünü elle uygulamak
- SOLID prensiplerine uygun, genişletilebilir bir yapı kurmak

## Özellikler

- `ServerSocket` ile 1989. portu dinler
- Tarayıcıdan gelen HTTP isteğini okur
- `H1` başlığında ad soyad, `H2` başlığında öğrenci numarası gösterir
- Renk ve font biçimlendirmesi içeren kısa bir biyografi sunar
- Türkçe karakter desteği (UTF-8)
- Harici bağımlılık yoktur

## Proje Yapısı

```
.
├── Main.java              # Uygulamanın giriş noktası
├── WebServer.java         # Socket bağlantılarını yöneten sunucu sınıfı
├── PageProvider.java      # Sayfa içeriği sağlayan arayüz (interface)
├── BioPageProvider.java   # Biyografi HTML sayfasını üreten sınıf
└── README.md
```

## Sınıfların Görevleri

| Sınıf | Görev |
|---|---|
| `Main` | Nesneleri oluşturur ve sunucuyu başlatır |
| `WebServer` | `ServerSocket` ile bağlantı kabul eder, HTTP yanıtını istemciye yazar |
| `PageProvider` | Sunulacak HTML içeriği için sözleşme tanımlar |
| `BioPageProvider` | `PageProvider` arayüzünü uygular, HTML sayfasını üretir |

## Kurulum ve Çalıştırma

### Gereksinimler

- JDK 17 veya üzeri

Kurulumu kontrol etmek için:

```bash
java -version
javac -version
```

### Adımlar

1. Depoyu klonlayın:

```bash
git clone https://github.com/[KULLANICI_ADI]/[REPO_ADI].git
cd [REPO_ADI]
```

2. Derleyin:

```bash
javac *.java
```

3. Çalıştırın:

```bash
java Main
```

4. Terminalde şu çıktıyı görmelisiniz:

```
Sunucu çalışıyor: http://localhost:1989
```

5. Tarayıcıdan şu adrese gidin:

```
http://localhost:1989
```

6. Sunucuyu durdurmak için terminalde `Ctrl + C` tuşlarına basın.

## Ekran Görüntüsü
<img width="1114" height="617" alt="image" src="https://github.com/user-attachments/assets/bf600048-771f-400e-ac08-8dccb5c7a94d" />



## Çalışma Prensibi

1. Sunucu `ServerSocket` nesnesiyle 1989. portta istemci bağlantılarını bekler.
2. Tarayıcı bağlandığında `accept()` metodu bir `Socket` nesnesi döndürür.
3. Sunucu, `InputStream` üzerinden HTTP isteğini okur (`GET / HTTP/1.1` ve başlıklar).
4. `PageProvider` aracılığıyla HTML içeriği alınır.
5. Sunucu, `OutputStream` üzerinden önce HTTP durum satırını ve başlıkları (`200 OK`, `Content-Type`, `Content-Length`), ardından HTML gövdesini gönderir.
6. Bağlantı kapatılır ve sunucu yeni istek beklemeye devam eder.

## Socket, Port ve IP Kavramları

- **IP adresi:** Ağdaki bir cihazın benzersiz adresidir. Yerel testte `localhost` (127.0.0.1) kullanılır.
- **Port:** Bir cihazdaki farklı uygulamaları ayırt eden numaradır (0–65535). Bu projede 1989 kullanılmıştır.
- **Socket:** IP adresi ve port numarasının birleşiminden oluşan, iki uygulama arasındaki iletişim uç noktasıdır. Java'da sunucu tarafında `ServerSocket`, bağlantı kurulduktan sonra veri alışverişi için `Socket` kullanılır.

## SOLID Prensipleri

| Prensip | Uygulamadaki karşılığı |
|---|---|
| **S** – Single Responsibility | `WebServer` yalnızca bağlantıyı yönetir, `BioPageProvider` yalnızca HTML üretir |
| **O** – Open/Closed | Yeni bir sayfa eklemek için mevcut kod değiştirilmez, yeni bir `PageProvider` sınıfı yazılır |
| **L** – Liskov Substitution | `PageProvider` türündeki her sınıf, `WebServer` bozulmadan birbirinin yerine kullanılabilir |
| **I** – Interface Segregation | `PageProvider` arayüzü yalnızca tek bir metot (`getHtml`) içerir |
| **D** – Dependency Inversion | `WebServer`, somut sınıfa değil `PageProvider` soyutlamasına bağımlıdır |

## Olası Sorunlar

| Sorun | Çözüm |
|---|---|
| `Address already in use` | 1989 portunu kullanan başka bir uygulamayı kapatın |
| `'javac' is not recognized` | JDK kurulumunu ve PATH ayarını kontrol edin |
| Türkçe karakterler bozuk | Dosyaları UTF-8 olarak kaydedin |

## Lisans

Bu proje eğitim amaçlı hazırlanmıştır.
