//right
function f() {

    myBool = false;

    someActions(function () {

        if (myBool == false) {
            alert('false at begin');
            createInfo();

        } else {
            alert('true at begin');
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

    //var myBool = false;

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

        VK.api('users.get', {uids: id, fields: 'uid'}, function f(r) {

            if (r.response) {

                for (var i = 0; i < r.response.length; i++) {

                    if (r.response[i].deactivated == 'deleted'
                        || r.response[i].deactivated == 'banned') {
                        alert('Пользователя с данным id не существует не существует : ' + id[i]);
                        myBool = true;
                    }
                }

                if (myBool == false) {
                    alert('false');

                } else {
                    alert('true');
                }

                callback1();
            }
        });
    }

}




