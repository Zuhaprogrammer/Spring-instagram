window.onload = function () {
    getFollowings();
}

async function getFollowings() {
    const userId = document.getElementById('stories').dataset.id;
    const url = "http://localhost:8080/follow/" + userId + "/following-list";
    const encodedUrl = encodeURI(url);
    try {
        const res = await fetch(encodedUrl);
        renderStories(await res.json());
    } catch (error) {
        console.log("Occur error: ",  error);
    }
}

function renderStories(followingList) {
    const stories = document.getElementById('stories');

    let temp = "";
    for (let i = 0; i < followingList.length; i++) {
        temp += "<div class=\"story\">"+ followingList[i].content === null ? +"<img src=\"/images/user-profile-icon-free-vector.jpg\" alt=\"User\">" : +
            "<img th:src=\"@{'/file/' +"+ followingList[i].content.contentName +"\" alt=\"User\"><p>"+ followingList[i].username +"</p></div>";
    }
    stories.innerHTML = temp;
}