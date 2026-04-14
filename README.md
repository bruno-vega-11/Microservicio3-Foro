# Microservicio3-Foro
Microservicio destinado al foro entre usuarios

Para probarlo tienes que hacer 2 cosas:
1. Tienes que crear un thread
   Entra a Postman haz un metodo post  http://{inserta_host}:8080/api/threads con body
   {
    "userId": "user_001",
    "movieId": "movie_001",
    "title": "¿Qué opinan de Inception?",
    "body": "Para mí es una obra maestra"
   }
   
2. Usa el stomp.html
   Copia el id que te da la respuesta lo pegas donde te pida threadID, le das a conectar y listo

##IMPORTANTE
  El stomp.html esta configurado para que el websocket se diriga a una direccion, si levantas la app y quieres probarlo chequea la direccion y cambiala
