#include "IRremote.h" // IRRemote library from elegoo.com/download

int receiver = 11; // Signal Pin of IR receiver to Arduino Digital Pin 11

boolean isConnected = false;
int counter = 0;

IRrecv irrecv(receiver);
decode_results results;

void setup(){
  Serial.begin(9600);
  Serial.println("IR Receiver Button Decode"); 
  irrecv.enableIRIn(); // Start the receiver

}


void loop(){
  if (irrecv.decode(&results)) // have we received an IR signal?
  {
    isConnected = true;
    irrecv.resume(); // receive the next value
  } else { // No signal detected

    if (isConnected) { // Increase counter if switching from open to blocked
      counter++;
      Serial.println(counter); // Transmit counter data over i2c here
    }

    isConnected = false;
  }
  delay(125);
}