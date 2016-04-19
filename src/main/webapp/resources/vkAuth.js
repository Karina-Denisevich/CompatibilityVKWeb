function createInfo() {
    var ids = [];
    var sexes = [];
    var bDates = [];
    var artists = [];

    VK.init(function () {
            getUserInfoVK();
        }
    );

    function getUserInfoVK() {
        VK.api('users.get', {uids: '50181012, idgoaway1, 133930656', fields: 'uid, sex, bdate'}
            , function f(r) {

                if (r.response) {

                    var i;
                    for (i = 0; i < r.response.length; i++) {

                        ids.push(r.response[i].uid);
                        sexes.push(r.response[i].sex);
                        bDates.push(r.response[i].bdate);
                    }

                    $('#clientForm\\:vkId').val(ids);
                    $('#clientForm\\:vkSex').val(sexes);
                    $('#clientForm\\:vkBdate').val(bDates);
                    $('#clientForm\\:but1').click();
                    $('#clientForm\\:but2').click();
                    $('#clientForm\\:but3').click();
                }
                // for(var i = 0; i < ids.length; i++) {
                getUserAudio(0);
                // }
            }
        );
    }


    function getUserAudio(i) {

        VK.api('audio.get', {owner_id: ids[i], count: '3'}, function (audio) {
            if (audio.response) {
                for (var j = 1; j < audio.response.length; j++) {
                    //alert(audio.response[j].artist);
                    artists.push(audio.response[j].artist);
                }
            } else {
                artists.push(null);
            }
            $('#clientForm\\:vkAudio').val(artists);
            $('#clientForm\\:but4').click();
            artists = [];
            i++;
            if (i < ids.length) {
                getUserAudio(i);
            }
        });
    }
}
