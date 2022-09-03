/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/* global fetch, moment */

function deletePro(endpoint, id, obj) {
    let d = document.getElementById("load" + id);
    d.style.display = "block";
    obj.style.display = "none";

    fetch(endpoint, {
        method: "delete"
    }).then(function (res) {
        if (res.status === 204)
        {
            let r = document.getElementById("row" + id);
            r.style.display = "none";
        }

    }).catch(function (err) {
        console.error(err);
    });
}

function loadAdminProduct(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.info(data);
        let msg = "";
        for (let i = 0; i < data.length; i++)
            msg += `
                <tr id="row${data[i].id}">
                    <td><img src="${data[i].image}" width='120' /></td>
                    <td>${data[i].name}</td>
                    <td>${data[i].price} VND</td>
                    <td>
                        <div class="spinner-border text-success" style="display:none" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deletePro('${endpoint + '/' + data[i].id}', ${data[i].id}, this)">Xoa</button>
                    </td>
                </tr>
        `

        let d = document.getElementById("mainId");
        d.innerHTML = msg;

        let d2 = document.getElementById("myLoading");
        d2.style.display = "none";
    });
}

function loadComments(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let c = document.getElementById("comments");
        let h = '';
        for (let d of data)
            h += `
                <li class="list-group-item"><em>${d.content}</em> duoc binh luan boi <strong>${d.user.username}</strong> vao luc <strong>${moment(d.createdDate).locale("vi").fromNow()}</strong></li>
            `;
        c.innerHTML = h;
    });
}

function addComment(endpoint, proId) {
    fetch(endpoint, {
        method: "post",
        body: JSON.stringify({
            "content": document.getElementById("contentId").value,
            "productId": proId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.querySelector("#comments li:first-child");
        let h = `
                <li class="list-group-item"><em>${data.content}</em> duoc binh luan boi <strong>${data.user.username}</strong> vao luc <strong>${moment(data.createdDate).locale("vi").fromNow()}</strong></li>
            `;
        d.insertAdjacentHTML("beforebegin", h);
    });
}

function addToCart(id, name, price) {
    event.preventDefault();
    fetch("/SanTMDT/api/cart", {
        method: "post",
        body: JSON.stringify({
            "productId": id,
            "productName": name,
            "price": price,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter")
        counter.innerText = data;
    });
}

function updateCart(obj, productId) {
    fetch("/SanTMDT/api/cart", {
        method: "put",
        body: JSON.stringify({
            "productId": productId,
            "productName": "",
            "price": 0,
            "quantity": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data.counter;
        let amount = document.getElementById("amountCart");
        amount.innerText = data.amount;
    });
}

function deleteCart(productId) {
    fetch(`/SanTMDT/api/cart/${productId}`, {
        method: "delete"
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data.counter;
        let amount = document.getElementById("amountCart");
        amount.innerText = data.amount;
        let row = document.getElementById(`product${productId}`)
        row.style.display = "none"
    });
}

function pay() {
    if (confirm("Ban chac chan thanh toan?") == true) {
        fetch("/SanTMDT/api/pay", {
            method: "post"
        }).then(function (res) {
            return res.json();
        }).then(function (code) {
            console.info(code);
            location.reload();
        });
    }
}
