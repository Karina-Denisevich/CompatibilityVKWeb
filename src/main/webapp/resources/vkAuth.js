function createInfo() { //add
    var ids = [];
    var names = [];
    var sexes = [];
    var bDates = [];
    var artists = [];
    var identificsArr;
    var identifics = "";


    identificsArr = document.getElementsByClassName('vkIden');

    for (var i = 0; i < identificsArr.length; i++) {
        identifics += identificsArr[i].value;
        if (i < identificsArr.length - 1) {
            identifics += ', ';
        }
    }

    VK.init(function () {
            getUserInfoVK();
        }
    );

    function getUserInfoVK() {
        VK.api('users.get', {uids: identifics, fields: 'uid, sex, bdate'}, function f(r) {

                if (r.response) {

                    for (var i = 0; i < r.response.length; i++) {

                        ids.push(r.response[i].uid);
                        names.push(r.response[i].first_name + " " + r.response[i].last_name)
                        sexes.push(r.response[i].sex);
                        bDates.push(r.response[i].bdate);
                    }

                    $('#clientForm\\:vkId').val(ids);
                    $('#clientForm\\:vkName').val(names);
                    $('#clientForm\\:vkBdate').val(bDates);
                    $('#clientForm\\:vkSex').val(sexes);

                    $('#clientForm\\:link1').click();
                    $('#clientForm\\:link2').click();
                    $('#clientForm\\:link3').click();
                    $('#clientForm\\:link4').click();

                    getUserAudio(0);
                }
            }
        )
    }


    function getUserAudio(i) {

        VK.api('audio.get', {owner_id: ids[i], count: '300'}, function (audio) {

            if (audio.response) {

                for (var j = 1; j < audio.response.length; j++) {
                    artists.push(audio.response[j].artist);
                }
            } else {
                artists.push("");
            }

            $('#clientForm\\:vkAudio').val(artists);
            $('#clientForm\\:link5').click();

            artists = [];
            i++;

            if (i < ids.length) {
                getUserAudio(i);
            } else {
                $('#clientForm\\:link6').click();
                setTimeout(function() {
                    window.open("compatibilityTable.xhtml", "_self");

                }, 600);
            }
        });
    }
}