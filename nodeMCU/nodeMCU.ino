#include <ESP8266WiFi.h>
#include <FirebaseArduino.h>
#include <SoftwareSerial.h>

// Set these to run example.
#define FIREBASE_HOST "securityclearance-55e9c.firebaseio.com"
#define FIREBASE_AUTH "8Nx2I4HSf61ZMaU8in6nfsX5ci4n80MhWQub7lbD"
#define WIFI_SSID "ryzen"
#define WIFI_PASSWORD "matilde22"
SoftwareSerial esp(D2,D3);

void setup() {
  Serial.begin(9600);
  esp.begin(4800);

  // connect to wifi.
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("connecting");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(500);
  }
  Serial.println();
  Serial.print("connected: ");
  Serial.println(WiFi.localIP());
  
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);

}

int n = 0;
int val,estado;
bool autoridade;
void loop() {

   while(esp.available()>0)
  {
     val = esp.parseInt();
     if(esp.read()=='\n')
     {
       Serial.println(val);
       
     }
    // set value
    if (val != 0)
    {
      Firebase.setInt("id", val);
       // handle error
       if (Firebase.failed()) {
        Serial.print("setting /lol failed:");
        Serial.println(Firebase.error());  
        return;
      }
      delay(300);  
      Firebase.setInt("Question",1);
    }
    
    // get value 
    Serial.print("id: ");
    Serial.println(Firebase.getInt("id"));
    delay(300); 


    Serial.print("Auth: ");
    autoridade = Firebase.getBool("Auth");
    Serial.println(autoridade);
    delay(50); 

    if (autoridade == 0)
    {
      Serial.print("Não tens autoridade");
      esp.print(autoridade);
      esp.println("\n");
    }

    
   // append a new value to /logs
   //  String name = Firebase.pushInt("logs", n++);
    //  // handle error
    //  if (Firebase.failed()) {
    //      Serial.print("pushing /logs failed:");
    //      Serial.println(Firebase.error());  
    //      return;
    //  }
    //  Serial.print("pushed: /logs/");
    //  Serial.println(name);
      Firebase.setInt("Answer",0);
      delay(100);
   }
}
