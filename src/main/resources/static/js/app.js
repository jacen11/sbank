const base_url = 'http://localhost:8080';
const account_url = base_url + '/api/account/';
// import axios from '../node_modules/axios';

var app = new Vue({
    el: '#app',
    data: {
        message: '',
        nameAccount: '',
        currency: '',
        accounts: {}

        //     [
        //     {
        //         "name": "qwe",
        //         "currency": "USD",
        //         "id": 1
        //     },
        //     {
        //         "name": "qwe",
        //         "currency": "USD",
        //         "id": 2
        //     },
        //     {
        //         "name": "qwe",
        //         "currency": "USD",
        //         "id": 3
        //     },
        //     {
        //         "name": "qwe",
        //         "currency": "USD",
        //         "id": 4
        //     }
        // ]
    },
    created() {
        this.getAccount().then(res => {
            this.accounts = res.data;
        })
    },
    methods: {
        getAccount: function() {
            return axios.get(account_url)
        },
        createAccount: function () {
            let account = {
                name: this.nameAccount,
                currency: this.currency
            };
            axios.put(account_url, account)
                .then(response => {
                    if (response.status === 200) {
                        this.message = "Сохранено"
                    } else {
                        this.message = "Не сохранено"
                    }
                })
                .catch(function (error) {
                    console.log( error);
                });
        }
    }
});
