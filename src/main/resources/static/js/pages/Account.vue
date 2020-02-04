<template>
    <table>
        <tr>
            <td><input v-model="nameAccount" placeholder="Введите название" type="text"/></td>
            <td><select v-model="currency" required>
                <option disabled value="">Выберите валюту</option>
                <option>USD</option>
                <option>RUB</option>
            </select></td>
            <td>
                <button v-on:click="createAccount">Создать</button>
            </td>
        </tr>
    </table>
    {{nameAccount}}
    {{currency}}
</template>

<script>
    export default {
        name: "Account",
        data() {
            return {
                account: {}
            }
        },
    }
</script>

<style scoped>

</style>