<script setup>
import { RouterLink } from "vue-router";
const props = defineProps({
  item: Object,
});
</script>

<template>
  <div>
    <RouterLink
      :to="{ name: 'MyListDetail', params: { pid: item.pid }, query: { title: item.title } }"
    >
      <div>{{ item.title }}</div>
    </RouterLink>
  </div>
</template>

<style scoped></style>
