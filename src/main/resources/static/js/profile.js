window.onload = function () {
    checkFollowExistence();
}

async function checkFollowExistence() {
    const followButton = document.getElementById('follow-button');
    const followingId = followButton.value;
    const url = "http://localhost:8080/follow/" + followingId + "/existence";
    const encodedUrl = encodeURI(url);
    try {
        const res = await fetch(encodedUrl);
        setFollow(await res.json());
    } catch (error) {
        console.log("Occur error: ", error);
    }
}

function setFollow(result) {
    const followButton = document.getElementById('follow-button');
    if (result) {
        followButton.classList.add('btn-outline-secondary');
        followButton.innerText = 'Following';
    } else {
        followButton.classList.add('btn-primary');
        followButton.innerText = 'Follow';
    }
}

async function searchUser() {
    const search = document.getElementById('search-input');
    if (search.value !== null) {
        const url = "http://localhost:8080/user/search/" + search.value;
        const encodedUrl = encodeURI(url);
        try {
            const res = await fetch(encodedUrl);
            renderSearchResult(await res.json());
        } catch (error) {
            console.log("Occur error: ", error);
        }
    }
}

function renderSearchResult(searchResult) {
    const result = document.getElementById('search-result');

    let temp = "";
    for (let i = 0; i < searchResult.length; i++) {
        temp += "<a href='/user/" + searchResult[i].id + "/profile' class='text-decoration-none text-dark'>\n" +
            "  <div class='user-suggestion d-flex align-items-center'>\n" +
            (searchResult[i].content == null
                ? "    <img src='/images/user-profile-icon-free-vector.jpg' alt='User' class='rounded-circle' style='width: 50px; height: 50px;'>\n"
                : "    <img src='/file/" + searchResult[i].content.contentName + "' alt='User' class='rounded-circle' style='width: 50px; height: 50px;'>\n") +
            "    <div class='d-flex flex-column justify-content-center' style='height: 100%;'>\n" +
            "      <span style='font-size: 12px; line-height: 1; font-weight: 900'>"
            + searchResult[i].username + "</span>\n" +
            "      <p class='m-0' style='font-size: 12px; line-height: 1;'>"
            + searchResult[i].fullName + "</p>\n" +
            "    </div>\n" +
            "  </div>\n" +
            "</a>";
    }
    result.innerHTML = temp;
}

// Sidebar toggle function
function toggleSidebar() {
    const sidebar = document.getElementById('sidebar');
    const newContainer = document.getElementById('newContainer');
    const mainContent = document.getElementById('mainContent');

    // Toggle sidebar shrink effect
    sidebar.classList.toggle('shrink');
    mainContent.classList.toggle('shrink'); // To adjust main content position

    // Toggle new container visibility
    newContainer.classList.toggle('open');

    // Adjust the new container's position when the sidebar shrinks
    if (sidebar.classList.contains('shrink')) {
        newContainer.style.left = "60px";  // Adjust to the shrunk sidebar width
    } else {
        newContainer.style.left = "250px"; // Adjust back to the full sidebar width
    }
}