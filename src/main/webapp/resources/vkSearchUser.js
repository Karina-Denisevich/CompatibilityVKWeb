function mainUser(id) {

    var ids = [];
    var names = [];
    var sexes = [];
    var bDates = [];
    var artists = [];


    VK.init(function () {
            getUserInfoVK();
        }
    );

    function getUserInfoVK() {
        VK.api('users.get', {user_ids: id,fields: 'uid, sex, bdate'}, function f(r) {

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

                    getUserAudio();
                }
            }
        )
    }


    function getUserAudio() {

        VK.api('audio.get', {owner_id: ids[0], count: '300'}, function (audio) {

            if (audio.response) {

                for (var j = 1; j < audio.response.length; j++) {
                    artists.push(audio.response[j].artist);
                }
            } else {
                artists.push("");
            }

            $('#clientForm\\:vkAudio').val(artists);
            $('#clientForm\\:link5').click();


        });
    }
}

