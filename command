#Docker para construir a imagem no Dockerfile
docker build -t negoreserva:latest .

docker-compose -f docker-compose.dev.yml up --build
docker-compose up --build --force-recreate

#O binário executável será gerado dentro da pasta /build/target/
mvn clean package -Pnative -DskipTests
./mvnw -Pnative compile:native
mvnw.cmd native:compile

->Comando do ubuntu

1. Corrigir o contexto do Docker

Liste os contextos: docker context ls
Mude para o contexto padrão: docker context use default
Teste a conexão: docker ps

2. Verificar se o Docker Engine está rodando
Se o comando acima falhar, o serviço do Docker pode não estar ativo:

Inicie o serviço: sudo systemctl start docker
Habilite para iniciar com o sistema: sudo systemctl enable docker
Verifique o status: sudo systemctl status docker
Reinicia o docker: sudo systemctl restart docker