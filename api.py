import flask
from flask import jsonify
import pusher
import values


app = flask.Flask(__name__)
app.config['DEBUG'] = True

pusher_client = pusher.Pusher(
    app_id=values.APP_ID,
    key=values.KEY,
    secret=values.SECRET,
    cluster=values.CLUSTER,
    ssl=values.SSL
)

info = {
    'restaurants': [{
            'r_id': 0,
            'name': "Papa Mario's Pizza",
            'channel': 'mario-channel',
            'tables': 5,
            'menu': [
                {
                    'f_id': 0,
                    'name': 'Breakfast Pizza',
                    'price': 19.99,
                    'link': "https://www.farmwifecooks.com/wp-content/uploads/2019/09/BreakfastPizza-2.jpg"
                },

                {
                    'f_id': 1,
                    'name': 'Breakfast Calzone',
                    'price': 19.99,
                    'link': "https://images-gmi-pmc.edge-generalmills.com/edd5ac34-2e24-4606-a0f1-048ced16a7a7.jpg"
                },

                {
                    'f_id': 2,
                    'name': 'Scrambled Eggs',
                    'price': 5.99,
                    'link': "https://toriavey.com/images/2014/06/scrambled_eggs_001.jpg"
                },

                {
                    'f_id': 3,
                    'name': 'Cheese Pizza',
                    'price': 15.99,
                    'link': "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2021/03/30/0/FNM_050121-Thin-Crust-Pizza_s4x3.jpg.rend.hgtvcom.826.620.suffix/1617129472994.jpeg"
                },

                {
                    'f_id': 4,
                    'name': 'Pepperoni Pizza',
                    'price': 16.49,
                    'link': "https://cdn.ruled.me/wp-content/uploads/2014/08/pepperonipizza.jpg"
                },

                {
                    'f_id': 5,
                    'name': 'Supreme Pizza',
                    'price': 17.99,
                    'link': "https://www.caseys.com/medias/sys_master/images/h47/h8b/8796496461854/8173_base-400x400/8173-base-400x400.png"
                },

                {
                    'f_id': 6,
                    'name': 'Coca-Cola',
                    'price': 3.99,
                    'link': "https://us.coca-cola.com/content/dam/nagbrands/us/coke/en/home/coca-cola-original-20oz.png"
                }
            ]
        },
        {
            'r_id': 1,
            'name': 'Buffet Shack',
            'channel': 'buffet-channel',
            'tables': 5,
            'menu': [
                {
                    'f_id': 0,
                    'name': 'Sliders',
                    'price': 10.99,
                    'link': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSB-9CCoWF1GgBNgGTYuCsQlUJOVzdhnyv_SQ&usqp=CAU'
                },
                {
                    'f_id': 1,
                    'name': 'Shrimp',
                    'price': 12.34,
                    'link': 'https://previews.123rf.com/images/tangducminh/tangducminh1511/tangducminh151100097/49193073-boiled-shrimp-in-buffet-restaurant.jpg'
                },
                {
                    'f_id': 2,
                    'name': 'Chow Mein',
                    'price': 5.99,
                    'link': 'https://choosygourmand.files.wordpress.com/2010/10/dsc01614.jpg'
                },
                {
                    'f_id': 3,
                    'name': 'Steak',
                    'price': 19.99,
                    'link': 'https://hips.hearstapps.com/del.h-cdn.co/assets/18/08/1519155106-flank-steak-horizontal.jpg'
                },
                {
                    'f_id': 4,
                    'name': 'Mashed Potatoes',
                    'price': '2.99',
                    'link': 'https://www.delicioustable.com/wp-content/uploads/2018/11/Make-Ahead-Mashed-Potatoes-Reheated-5-Ways-Recipe-680x1020.jpg'
                },
                {
                    'f_id': 5,
                    'name': 'Soup',
                    'price': 5.99,
                    'link': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZZw74uo59NBfcGPWF9Dlu79sYMzKDzMDl2Q&usqp=CAU'
                },
{
                    'f_id': 6,
                    'name': 'Coca-Cola',
                    'price': 3.99,
                    'link': "https://us.coca-cola.com/content/dam/nagbrands/us/coke/en/home/coca-cola-original-20oz.png"
                }
            ]
        }
    ],

    'employees': [
        {
            'employeeID': 0,
            'r_id': 0,
            'channel': 'mario-channel',
            'name': 'Armando',
            'birthday': '01-01-1980',
            'email': 'armando@mariopizza.com',
            'password': 'pizzapizza',
            'restaurant': "Papa Mario's Pizza",
            'manager': True
        },
        {
            'employeeID': 1,
            'r_id': 1,
            'name': 'Justin',
            'channel': 'buffet-channel',
            'birthday': '02-02-1990',
            'email': 'justin@buffetshack.com',
            'password': 'buffetbuffet',
            'restaurant': 'Buffet Shack',
            'manager': True
        }
    ],

    'customers': [
        {
            'customerID': -10,
            'name': 'Guest',
            'birthday': '03-03-1762',
            'email': 'guest@example.com',
            'password': 'password',
            'visited': ["Papa Mario's Pizza"]
        }
    ]
}

defaults = [
    {
        'employeeID': -1,
        'r_id': -1,
        'name': 'Default',
        'channel': 'Default',
        'birthday': 'Default',
        'email': 'Default',
        'password': 'Default',
        'restaurant': 'Default',
        'manager': False
    },
    {
        'customerID': -1,
        'name': 'Default',
        'birthday': 'Default',
        'email': 'Default',
        'password': 'Default',
        'visited': []
    }
]


@app.route('/', methods=['GET'])
def home():
    return 'Home'


# Returns all info
@app.route('/api/v1/all', methods=['GET'])
def api_all():
    return jsonify(info)


@app.route('/api/v1/menu/<int:r_id>', methods=['GET'])
def get_menu(r_id):
    return jsonify(info['restaurants'][r_id]['menu'])


# Service for restaurant table
@app.route('/api/v1/service/<int:r_id>/<int:table>', methods=['GET'])
def send_service(r_id, table):
    pusher_client.trigger(info['restaurants'][r_id]['channel'], 'service', {'table': table})
    return '200'


# Order for restaurant item
@app.route('/api/v1/order/<int:r_id>/<int:table>/<int:f_id>', methods=['GET'])
def send_order(r_id, table, f_id):
    pusher_client.trigger(info['restaurants'][r_id]['channel'], 'order', {'table': table, 'order': info['restaurants'][r_id]['menu'][f_id]})
    return '200'


# Checks if user exists
@app.route('/api/v1/check/<utype>/<email>', methods=['GET'])
def check_user(utype, email):
    for c in info[utype]:
        if email == c['email']:
            return '200'
    return '400'



# Adds user
@app.route('/api/v1/add/<utype>/<name>/<birthday>/<email>/<password>', methods=['GET'])
def add_user(utype, name, birthday, email, password):
    if check_user(utype, email) == '200':
        return '400'

    if utype == 'customers':
        info['customers'].append({
            'customerID': values.CURRENT_CUSTOMER_NUM,
            'name': name,
            'birthday': birthday,
            'email': email,
            'password': password,
            'visited': []
        })
        values.CURRENT_CUSTOMER_NUM += 1
    elif utype == 'employees':
        info['employees'].append({
            'employeeID': values.CURRENT_EMPLOYEE_NUM,
            'name': name,
            'birthday': birthday,
            'email': email,
            'password': password,
            'manager': False
        })
        values.CURRENT_EMPLOYEE_NUM += 1
    else:
        return '404'
    return '200'


# Edits user
@app.route('/api/v1/edit/<utype>/<email>/<part>/<value>', methods=['GET'])
def edit_user(utype, email, part, value):
    for c in info[utype]:
        if c['email'] == email:
            c[part] = value
            return '200'
    return '404'


# Deletes user
@app.route('/api/v1/delete/<utype>/<email>', methods=['GET'])
def delete_user(utype, email):
    for c in info[utype]:
        if c['email'] == email:
            del c
            return '200'
    return '404'


# Checks user and password combination
@app.route('/api/v1/checkpass/<utype>/<email>/<password>', methods=['GET'])
def check_user_password(utype, email, password):
    for c in info[utype]:
        if c['email'] == email:
            if c['password'] == password:
                return c
    if utype == 'customers':
        return defaults[1]
    else:
        return defaults[0]


# Returns a user JSON object
@app.route('/api/v1/getuser/<utype>/<email>', methods=['GET'])
def get_user(utype, email):
    for c in info[utype]:
        if c['email'] == email:
            return c
    return None


# Returns number of tables
@app.route('/api/v1/tables/<int:r_id>', methods=['GET'])
def get_tables(r_id):
    return str(info['restaurants'][r_id]['tables'])


# Returns a restaurant's channel
@app.route('/api/v1/channel/<int:r_id>', methods=['GET'])
def get_channel(r_id):
    return info['restaurants'][r_id]['channel']


# Returns all restaurant's name
@app.route('/api/v1/restaurants', methods=['GET'])
def get_restaurants():
    arr = []
    for r in info['restaurants']:
        arr.append(r['name'])
    return jsonify(arr)


app.run()
