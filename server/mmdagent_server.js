var express = require('express');
var corser = require('corser');
var http =require('http');
var app = express();
var bodyParser = require('body-parser');

console.log('server running');

// app.use(bodyParser());
app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());

// クロスドメインアクセスを許可する
// 同一生成元ポリシーに関するクロスドメインについて勉強しておくこと
app.use(corser.create());

var server = http.createServer(app);

/* socket.IOのインスタンス生成 */
var socketIO = require('socket.io');

var io = socketIO.listen(server);

/* クライントが接続してたときの処理 */
io.sockets.on('connection', function(socket){
	console.log("connection");
});

/* MMDAgentへ送信するメッセージをJSONで受付 */
app.post("/mmdagent/api/message", function(req, res){
	console.log(req.body);

	io.sockets.emit('message', req.body);

	res.send(req.body);
});

/* port:3000で待機 */
port = process.env.PORT || 3000;
server.listen(port, function(){
	console.log("server listening on port 8080");
});
