<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { insert } from "../api/customer.js";
const router = useRouter();

const num = ref("");
const name = ref("");
const address = ref("");

function customerInsert() {
  insert(
    { num: num.value, name: name.value, address: address.value },
    (res) => {
      if (res.status == 200) router.push("/list");
    },
    (e) => {
      console.log(e);
    }
  );
}
function customerAll() {
  router.push("/list");
}
</script>

<template>
  <div>
    <div class="container">
      <slot></slot>
      <form id="form1" class="form-horizontal">
        <slot name="list"></slot>
        <div class="form-group">
          <label>번호:</label> <input type="text" class="form-control" id="num" v-model="num" />
        </div>
        <div class="form-group">
          <label>이름:</label> <input type="text" class="form-control" id="name" v-model="name" />
        </div>

        <div class="form-group">
          <label>주소:</label>
          <input type="text" class="form-control" id="address" v-model="address" />
        </div>

        <div class="btn-group">
          <input
            type="button"
            class="btn btn-primary"
            value="등록"
            id="btnInsert"
            @click="customerInsert"
          />
          <input
            type="button"
            class="btn btn-primary"
            value="전체"
            id="btnUpdate"
            @click="customerAll"
          />
          <input type="reset" class="btn btn-primary" value="초기화" id="btnInit" />
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped></style>
