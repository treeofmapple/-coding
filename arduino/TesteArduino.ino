void setup() {

  Serial.begin(115200);
  pinMode(A0, INPUT);
  pinMode(LED_BUILTIN, OUTPUT);
}

int entrada, entradaAnterior;

void loop() {

  entrada = analogRead(A0);

  float entradas1 = entrada * (5.0 / 1023.0);

  if ( entradas1 != entradaAnterior ) {
    Serial.println( entradas1 ) ;
    entradaAnterior = entrada;
  }

  if (entradas1 > 3.10) {
    digitalWrite(LED_BUILTIN, HIGH);
  } else {
    digitalWrite(LED_BUILTIN, LOW);
  }

  delay(100);

}
