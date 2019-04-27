import pika


credenciais = pika.PlainCredentials('JumiaUser', 'JumiaPass')
parameters = pika.ConnectionParameters(host='localhost', port=5672,
    virtual_host = 'JumiaVirtualHost', credentials=credenciais)

connection = pika.BlockingConnection(parameters)
channel = connection.channel()

message =  {"id":200, "name":"Mensagem enviada pelo PYTHON!"}
for i in range(1, 2):
    channel.basic_publish(exchange='JumiaExchange', routing_key='JumiaKey', body= str(i) + " " + str(message), properties=pika.BasicProperties(delivery_mode = 2))    
    print(str(i) + "[*] %r" % message)

connection.close()
 

 