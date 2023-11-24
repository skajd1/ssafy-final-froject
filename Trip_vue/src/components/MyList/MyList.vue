<script setup>
import MyListItem from "@/components/MyList/MyListItem.vue";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
import { ref, reactive } from "vue";
import { useUserStore } from "@/stores/userStore";
const store = usePlanStore();
const { allPlan } = store;
const { all: items } = storeToRefs(store);
const { user } = storeToRefs(useUserStore());

allPlan(user.value.uid);
</script>

<template>
  <div id="container">
    <!-- <div>{{ item.title }}</div> -->
    <MyListItem v-for="item in items" :item="item" class="planbox"></MyListItem>
  </div>
</template>

<style lang="scss" scoped>
#container {
  /* background-color: var(--main-color-bg); */
  margin: 10px auto;
  min-height: 800px;
  width: 85%;
  border-radius: 10px;

  display: grid;
  grid-template-columns: 300px 300px 300px 300px 300px;
  grid-auto-rows: minmax(280px, 280px);
  gap: 20px;
  row-gap: 80px;
  padding: 20px;
}
</style>
