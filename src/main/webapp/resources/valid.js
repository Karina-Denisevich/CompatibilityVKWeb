//right
function f() {

    myBool = false;

    someActions(function () {

        if (myBool == false) {
            alert('false at begin');

            createInfo();
             return false;

        } else {
            alert('true at begin');
            return true;
        }

    });

    return myBool != false;
}


function someActions(callback) {

    alert('it is somaact');
    myBool = false;


    validate(function () {
        callback();
    });

}



function validate(callback1) {
    var iden = document.getElementsByClassName('vkIden');
    var id = "";


    for (var i = 0; i < iden.length; i++) {
        id += iden[i].value;
        if (i < iden.length - 1) {
            id += ', ';
        }
    }

    VK.init(function () {
            getUserInfoVK();
        }
    );


    function getUserInfoVK() {

        var errors = " ";

        VK.api('users.get', {uids: id, fields: 'uid'}, function f(r) {

            if (r.response) {

                for (var i = 0; i < r.response.length; i++) {

                    if (r.response[i].deactivated == 'deleted'
                        || r.response[i].deactivated == 'banned') {
                        errors += r.response[i].uid + " ";
                        myBool = true;
                    }
                }

                if (myBool == true) {
                    alert('Пользователей с данными id не существует : ' + errors);
                }

                callback1();

            }else{

                myBool = true;
                alert('Ошибка данных!');
                callback1();
            }
        });
    }

}
