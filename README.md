# Socket Client Server Project

## Introduction

------------


Soket , bir ağda adlandırabileceğiniz ve adresleyebileceğiniz bir iletişim bağlantı noktasıdır (uç nokta). Soket programlama, uzak ve yerel süreçler arasında iletişim bağlantıları kurmak için soket API'lerinin nasıl kullanılacağını gösterir.

## Dependencies
------------
Java, Socket Programming

## Table of content

------------

- [Documentation](https://github.com/latifkara/Socket_client_server "Documentation")
- [Features](https://github.com/latifkara/Socket_client_server "Features")

## Documentation
The documentation can be found [here](https://socketio.github.io/socket.io-client-java/installation.html "here").

## Features
```SocketServer``` is threaded. It creates a thread for accepting connections and creates a new thread each time a new client is connected. ```SocketClient``` is not threaded and the function ```readLine()``` blocks.
