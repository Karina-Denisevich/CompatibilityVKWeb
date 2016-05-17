function add() {

    var e1 = document.getElementsByClassName("button-add");
    var e2 = document.getElementsByClassName("submitResult");

    e1[e1.length - 1].style.display = 'none';
    e2[e2.length - 1].style.display = 'none';

    var form = document.getElementById('validForm');

    var divFirst = document.createElement('div');
    divFirst.className = 'idDiv';
    divFirst.style.display = 'flex';


    var divSecond = document.createElement('div');
    divSecond.className = 'input-group idInput';

    var span = document.createElement('span');
    span.className = 'input-group-addon';
    span.innerText = e1.length+1;

    var text = document.createElement('input');
    text.type = 'text';
    text.className = 'form-control vkIden';
    text.placeholder = 'ID';

    divSecond.appendChild(span);
    divSecond.appendChild(text);

    divFirst.appendChild(divSecond);


    var divThird = document.createElement('div');
    divThird.className = 'button-add';

    var but = document.createElement('button');
    but.type = 'button';
    but.className = 'btn btn-default btn-lg btn-add';

    but.onclick = function () {
        add();
    };

    var spanBut = document.createElement('span');
    spanBut.className = 'glyphicon glyphicon-plus-sign span-add';

    but.appendChild(spanBut);

    divThird.appendChild(but);
    divFirst.appendChild(divThird);


    var submit =  document.createElement('input');
    submit.type = 'submit';
    submit.className='btn btn-primary btn-large submitResult';
    submit.value='Узнать совместимость';

    var goFinal = document.createElement('div');
    goFinal.className = 'going-to-final';

    goFinal.appendChild(submit);


    form.appendChild(divFirst);
    form.appendChild(goFinal);

}
