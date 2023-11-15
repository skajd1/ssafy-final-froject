<script setup>
import { ref, onMounted } from "vue";
import { selectOne, deleteOne, update } from "../api/customer.js";
import { useRouter, useRoute } from "vue-router";
const c = ref({});
const route = useRoute();
const router = useRouter();

onMounted(() => {
  getOne();
});
function getOne() {
  selectOne(
    route.params.num,
    (res) => {
      c.value = res.data;
    },
    (e) => {
      console.log(e);
    }
  );
}
function customerDelete() {
  deleteOne(
    route.params.num,
    (res) => {
      if (res.status == 200) router.push("/list");
    },
    (e) => {
      console.log(e);
    }
  );
}
function customerUpdate() {
  update(
    { num: c.value.num, name: c.value.name, address: c.value.address },
    () => {
      router.push(`/list`);
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
          <label>번호:</label>
          <input type="text" class="form-control" id="num" v-model="c.num" readonly />
        </div>
        <div class="form-group">
          <label>이름:</label> <input type="text" class="form-control" id="name" v-model="c.name" />
        </div>

        <div class="form-group">
          <label>주소:</label>
          <input type="text" class="form-control" id="address" v-model="c.address" />
        </div>

        <div class="btn-group">
          <input
            type="button"
            class="btn btn-primary"
            value="수정"
            id="btnUpdate"
            @click="customerUpdate"
          />
          <input
            type="button"
            class="btn btn-primary"
            value="삭제"
            id="btnDelete"
            @click="customerDelete"
          />
          <input
            type="button"
            class="btn btn-primary"
            value="전체"
            id="btnUpdate"
            @click="customerAll"
          />
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped></style>
