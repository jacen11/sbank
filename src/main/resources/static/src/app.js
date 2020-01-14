const base_url = 'http://localhost:8080';
const account_url = base_url + '/api/account/';
// import axios from '../node_modules/axios';

var app = new Vue({
    el: '#app',
    data: {
        message: 'asfs',
        nameAccount: '',
        currency: ''
    },
    methods: {
        createAccount: function () {
            let account = {
                name: this.nameAccount,
                currency: this.currency
            };
            console.log(account);
            console.log(account_url);
            axios
                .put(account_url, account)
                .then(response => (this.message = response))
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
});
