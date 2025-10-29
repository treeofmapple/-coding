void setup() {

  Serial.begin(115200);
  pinMode(A0, INPUT);
}

int entrada, entradaAnterior;
int posicao = 0, i, medicoes[5], soma;
float tensao;

void loop() {

  entrada = analogRead(A0);

  medicoes [ posicao ] = entrada;
  if ( posicao < 5 ) { 
    posicao++;
  }
  else posicao = 0;

  soma = 0;

for ( i = 0; i < 5; i++) {
    soma += medicoes [ i ];
  }

  tensao = (soma /16) * 5.0 / 1023.0;

  if ( entrada != entradaAnterior ) {
    Serial.println( entrada );
    Serial.println( tensao,2 );
    entradaAnterior = entrada;
  }


  delay(100);

}
