<!-- vbase生成模板 -->
<template>
  <div>
    <h1>All Customers Page</h1>
    <input v-model="searchId" placeholder="搜尋會員ID" />
    <button @click="search">搜尋</button>

    <ul>
      <li v-for="customer in filteredCustomers" :key="customer.id">
        {{ customer.customerId }} - {{ customer.customerName }}
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";
  
const customers = ref([]);
const searchId = ref("");
const filteredCustomers = ref(customers.value);
const apiUrl = import.meta.env.VITE_API_JAVAURL;

const search = async () => {
  try {
    const response = await axios.get(
      `${apiUrl}public/api/customers/search?customerId=${searchId.value}`
    );
    filteredCustomers.value = response.data;
    console.log(filteredCustomers.value);
  } catch (error) {
    console.error("API 請求錯誤:", error);
    filteredCustomers.value = [];
  }
};

onMounted(() => {
  console.log("AllCustomer.vue is mounted.");
  search(); // 初始載入時進行搜尋
});
</script>

<style scoped>
h1 {
  text-align: center;
}

input {
  margin: 10px;
  padding: 5px;
}

button {
  padding: 5px 10px;
  cursor: pointer;
}

ul {
  list-style: none;
  padding: 0;
}

li {
  border: 1px solid #ccc;
  padding: 10px;
  margin: 5px 0;
  display: flex;
  justify-content: space-between;
}
</style>
