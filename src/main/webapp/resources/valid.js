function f() {
    myBool = false;
    errors = " ";
    isEmptyField = false;

    var finals = document.getElementsByClassName('going-to-final');
    finals[finals.length - 1].style.display = 'none';

    var e1 = document.getElementsByClassName("button-add");
    e1[e1.length - 1].style.display = 'none';

    document.getElementById('load').style.display = 'flex';

    someActions(function () {

        if (myBool == false) {
            createInfo();
            return false;

        } else {

            finals[finals.length - 1].style.display = 'flex';
            document.getElementById('load').style.display = 'none';
            e1[e1.length - 1].style.display = 'flex';
            return true;
        }
    });

    return myBool;
}


function someActions(callback) {

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
            getUserInfoVK(0);
        }
    );


    function getUserInfoVK(j) {

        VK.api('users.get', {uids: iden[j].value, fields: 'uid'}, function f(r) {
            if (r.response) {
                for (var i = 0; i < r.response.length; i++) {

                    if (r.response[i].deactivated == 'deleted'
                        || r.response[i].deactivated == 'banned') {

                        errors += r.response[i].uid + " ";
                        myBool = true;
                    }
                }

                if (r.response.length == 0) {
                    alert('Заполните все поля!');
                    myBool = true;
                    isEmptyField = true;
                    j = iden.length;
                }


                if (j < iden.length - 1) {
                    j++;
                    getUserInfoVK(j);
                } else {
                    if (myBool == true && !isEmptyField) {
                        alert('Пользователей с данными id не существует : ' + errors);
                    }
                    callback1();
                }

            } else {
                myBool = true;
                errors += iden[j].value + " ";

                if (j < iden.length - 1) {
                    j++;
                    getUserInfoVK(j);
                } else {
                    if (myBool == true && !isEmptyField) {
                        alert('Пользователей с данными id не существует : ' + errors + "!");
                    }
                    callback1();
                }
            }
        });
    }

}