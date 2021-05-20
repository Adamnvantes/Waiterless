import pusher

pusher_client = pusher.Pusher(
    app_id='1204716',
    key='fa5a261d11b91d27a570',
    secret='f61103dcd4152ba9bced',
    cluster='us3',
    ssl=True
)

pusher_client.trigger('my-channel', 'my-event1', {'table': 2})

#pusher_client.trigger('mario', 'need assistance', {'table': 2})

