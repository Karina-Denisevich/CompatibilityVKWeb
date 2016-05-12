function f1() {
    myBool1 = false;
    errors1 = " ";
    isEmptyField1 = false;

    if (document.getElementById('radioMe').checked) {
        mainUser("");
        document.getElementById('first').style.display = 'none';
        document.getElementById('second').style.display = 'block';
        return false;

    } else {
        someActions1(function () {

            if (myBool1 == false) {
                mainUser(iden1.value);
                document.getElementById('first').style.display = 'none';
                document.getElementById('second').style.display = 'block';
                return false;

            } else {
                return true;
            }
        });

        return myBool1;
    }
}


function someActions1(callbackk) {

    validate1(function () {
        callbackk();
    });

}

function validate1(callbackk1) {
    iden1 = document.getElementById('mainU');

    VK.init(function () {
            getUserInfoVK();
        }
    );


    function getUserInfoVK() {

        VK.api('users.get', {uids: iden1.value, fields: 'uid'}, function f(r) {

            if (r.response) {
                for (var i = 0; i < r.response.length; i++) {

                    if (r.response[i].deactivated == 'deleted'
                        || r.response[i].deactivated == 'banned') {

                        errors1 = r.response[i].uid;
                        myBool1 = true;
                    }
                }

                if (r.response.length == 0) {
                    alert('Заполните поле!');
                    myBool1 = true;
                    isEmptyField1 = true;
                }


                if (myBool1 == true && !isEmptyField1) {
                    alert('Пользователей с данным id не существует : ' + errors1);
                }
                callbackk1();


            } else {
                myBool1 = true;
                errors1 = iden1.value;

                if (myBool1 == true && !isEmptyField1) {
                    alert('Пользователей с данными id не существует : ' + errors1 + "!");
                }
                callbackk1();

            }
        });
    }

}
