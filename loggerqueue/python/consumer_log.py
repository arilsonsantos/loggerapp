import pika

credenciais = pika.PlainCredentials('JumiaUser', 'JumiaPass')
parameters = pika.ConnectionParameters(host='localhost', port=5672,
    virtual_host = 'JumiaVirtualHost', credentials=credenciais)

connection = pika.BlockingConnection(parameters)
channel = connection.channel()

result = channel.queue_declare(queue='JumiaQueue', exclusive=False, durable=True)
queue_name = result.method.queue

channel.queue_bind(exchange='JumiaExchange', routing_key="JumiaKey", queue=queue_name)

print(' [***** Para cancelar, pressione CTRL+C *****')

def callback(ch, method, properties, body):
    print(" [Mensagem recebida] -> %r" % body)

channel.basic_consume(queue=queue_name, on_message_callback=callback, auto_ack=True)

channel.start_consuming()